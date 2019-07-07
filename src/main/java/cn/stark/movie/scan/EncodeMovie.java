package cn.stark.movie.scan;

import ws.schild.jave.Encoder;
import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.VideoInfo;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class EncodeMovie {

    public static void main(String[] args) {
        File source = new File("K:\\美国往事\\Once.Upon.a.Time.in.America.1984.EXTENDED.1080p.BluRay.X264-AMIABLE.mkv");
        Encoder encoder = new Encoder();
        FileChannel fc= null;
        try {
            MultimediaObject multimediaObject = new MultimediaObject(source);
            MultimediaInfo multimediaInfo = multimediaObject.getInfo();
            VideoInfo videoInfo = multimediaInfo.getVideo();
            double min = multimediaInfo.getDuration() / 1000 / 60;
            System.out.println(min);
            System.out.println(videoInfo.getDecoder());
            System.out.println(videoInfo.getBitRate());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
