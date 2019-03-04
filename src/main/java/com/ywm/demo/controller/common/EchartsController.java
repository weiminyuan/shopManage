package com.ywm.demo.controller.common;

import com.ywm.demo.utils.PdfHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @Auther: chenjunhua
 * @Date: 2018/12/18 0018 16:19
 * @Description:
 */
@Controller
@RequestMapping("echarts")
public class EchartsController {

    @RequestMapping("/")
    public String hello() {
        return "/firstPdf";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save(HttpServletRequest request) {
        String result = null;
        try{
            String picBase64Info = request.getParameter("picBase64Info_twoChart");
            //获取图片的base64字符串,转换为数组
            String [] picBase64InfoArray = picBase64Info.split(",");
            byte[] imgByte = new BASE64Decoder().decodeBuffer(picBase64InfoArray[1]);
            //对异常的数据进行处理
            for(int i=0 ;i<imgByte.length;i++){
                if(imgByte[i]<0){
                    imgByte[i] += 256;
                }
            }
            //生成图片的地址
            String path= PdfHelper.getPath();
            String filePath = path+"static/picture/pdf/echartsMap.jpg";
            File imagesFile = new File(filePath);
            if(imagesFile.exists()){
                imagesFile.delete();
            }
            //保存图片  写入本地磁盘中
            OutputStream out = new FileOutputStream(imagesFile);
            out.write(imgByte );
            out.flush();
            out.close();
            result = "success";
        }catch (Exception e){
            e.printStackTrace();
            result = "fail";
        }
        return result;
    }
}
