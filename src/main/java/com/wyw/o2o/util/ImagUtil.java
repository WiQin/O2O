package com.wyw.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 图片处理
 *
 * @author wangyw
 * @date 2019/11/08
 */
public class ImagUtil {
    /**
     * 当前项目根路径
     */
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat SIMPLE_DATE_FORMATDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random R = new Random();

    /**
     * 处理缩略图
     *
     * @param thumbnail  上传图片
     * @param targerAddr 文件存储路径
     */
    public static String generateThumbnail(CommonsMultipartFile thumbnail, String targerAddr) {
        //获取随机的图片名称（用户上传的图片可能重名）
        String realFileName = getRandomFileName();
        //文件扩展名
        String extension = getFileExtension(thumbnail);
        //创建存储目录(可能不存在)
        makeDirPath(targerAddr);
        //获取相对路径
        String relativeAddr = targerAddr + realFileName + extension;
        //创建文件
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail.getInputStream()).size(200, 200)
                    .watermark(Positions.TOP_RIGHT, ImageIO.read(new File(basePath + "\\watermark.jpg")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 生成随机文件名，当前年月日时分秒+5位随机数
     *
     * @param
     */
    private static String getRandomFileName() {
        //获取随机五位数
        int randomNum = R.nextInt(89999)+1000;
        //当前时间
        String nowDateStr = SIMPLE_DATE_FORMATDateFormat.format(new Date());
        return nowDateStr+randomNum;
    }

    /**
     * 获取输入文件流扩展名
     *
     * @param cFile
     * @return
     */
    private static String getFileExtension(CommonsMultipartFile cFile) {
        String originalFileName = cFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
     * 创建目标路径上涉及到的目录
     *
     * @param targerAddr
     */
    private static void makeDirPath(String targerAddr) {
        //目标文件全路径
        String realFilePath = PathUtil.getImgBasePath()+targerAddr;
        File dirPath = new File(realFilePath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }


    public static void main(String[] args) throws IOException {
        System.out.println(basePath);
        Thumbnails.of(new File("d:\\Users\\Pictures\\new.jpg"))
                //像素大小
                .size(300, 300)
                .watermark(Positions.TOP_RIGHT, ImageIO.read(new File(basePath + "\\watermark.jpg")), 0.25f)
                .toFile("d:\\Users\\Pictures\\new1.jpg");
    }


}
