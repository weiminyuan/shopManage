package com.ywm.dataStructure.MyTree.huffmanTree;

import java.io.*;
import java.util.*;

/**
 * 赫夫曼编码
 * 1.数据转换从ascii码
 * 2.统计每个字符出现的次数
 * 3.创建一个赫夫曼树
 * 4.创建一个赫夫曼表（每个ascii对用一个树的子节点，唯一。左子树0，右子树1）
 * 5.压缩数据（将ascii转换成2进制）
 * <p>
 * 数据传输是通过byte 8位
 * <p>
 * 解压
 * 1.获取赫夫曼表
 * 2.解压压缩数据
 */
public class TestHuffmanTree {

    //用于临时存储
    static StringBuilder sb = new StringBuilder();
    static Map<Byte, String> huffCodes = new HashMap<>();

    public static void main(String[] args) {
//        String msg = "can you can a can as a can canner can a can.";
//        byte[] bytes = msg.getBytes();
//        //进行赫夫曼编码
//        byte[] b = huffmanZip(bytes);
//        //进行赫夫曼解码
//        byte[] newBytes = decode(huffCodes, b);
//        System.out.println(new String(newBytes));


    }

    /**
     * 压缩文件
     *
     * @param src   文件路径
     * @param dst   压缩文件路径
     * @throws IOException
     */
    public static void zipFile(String src, String dst) throws IOException {
        //创建一个输入流
        InputStream io = new FileInputStream(src);
        //创建一个和输入流指向的文件大小一样的byte数组
        byte[] b = new byte[io.available()];
        //读取文件内容
        io.read(b);
        io.close();
        //使用赫夫曼编码进行编码
        byte[] byteZip = huffmanZip(b);
        //输出流
        OutputStream os = new FileOutputStream(dst);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        //把压缩后的byte数组写入文件
        oos.write(byteZip);
        //把赫夫曼表写入文件
        oos.writeObject(huffCodes);
        oos.close();
        os.close();
    }


    private static byte[] decode(Map<Byte, String> huffCodes, byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        boolean flag;
        String key;
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            //最后一个
            flag = (i == bytes.length - 1);
            sb.append(byteToBitStr(!flag, b));
        }
        //把字符串按照规定的赫夫曼编码进行解码
        //把赫夫曼编码的键值对调换
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //创建一个集合，存byte
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < sb.length(); ) {
            int count = 1;
            flag = true;
            Byte b = null;
            while (flag) {
                key = sb.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;

        }
        byte[] codes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            codes[i] = list.get(i);
        }
        return codes;
    }

    private static String byteToBitStr(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    /**
     * 进行赫夫曼编码压缩方法
     *
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes) {
        //先统计每一个byte出现的次数，并放入一个集合中
        List<Node> nodes = getNodes(bytes);
        //创建一个赫夫曼树
        Node tree = createHuffmanTree(nodes);
        //创建一个赫夫曼表
        Map<Byte, String> huffCodes = getCodes(tree);
        //编码
        byte[] b = zip(bytes, huffCodes);
        return b;
    }

    /**
     * 进行赫夫曼编码
     *
     * @param bytes
     * @param huffCodes
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffCodes.get(b));

        }
        System.out.println(sb);
        //定义长度
        int length;
        if (sb.length() % 8 == 0) {
            length = sb.length() / 8;
        } else {
            length = sb.length() / 8 + 1;
        }
        //用于存储压缩后的byte
        byte[] by = new byte[length];
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String strByte;
            if (i + 8 > sb.length()) {
                strByte = sb.substring(i);
            } else {
                strByte = sb.substring(i, i + 8);
            }
            int number = Integer.parseInt(strByte, 2);
            byte byt = (byte) number;
            by[index] = byt;
            index++;
        }
        return by;
    }

    /**
     * @param tree
     * @return
     */
    private static Map<Byte, String> getCodes(Node tree) {
        if (tree == null) {
            return null;
        }
        getCodes(tree.left, "0", sb);
        getCodes(tree.right, "1", sb);
        return huffCodes;
    }

    private static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node.data == null) {
            getCodes(node.left, "0", sb2);
            getCodes(node.right, "1", sb2);
        } else {
            huffCodes.put(node.data, sb2.toString());
        }
    }

    /**
     * 创建赫夫曼树
     *
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            Node parent = new Node(null, left.weight + right.weight);
            parent.left(left);
            parent.right(right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 把byte数组转换成list集合
     *
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }
}
