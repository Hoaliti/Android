import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main() {
    //内存中创建宽和高为100的图片
    var image = BufferedImage(100,100,BufferedImage.TYPE_INT_RGB)
    var width = 0..99
    var height = 0..99
    image.apply {
        for(i in width){
            for(j in height){
                setRGB(i,j,0xff0000)
            }
        }
    }
    ImageIO.write(image,"bmp", File("a.bmp"))
}