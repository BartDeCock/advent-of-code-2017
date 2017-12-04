package adventofcode.util;

import io.reactivex.Flowable;
import io.reactivex.Observable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileConverter {

    public Flowable<String> getLines(String filename, String pattern) {
        return Flowable.using(
                () -> new BufferedReader(new FileReader(this.getClass().getClassLoader().getResource(filename).getFile())),
                reader -> Flowable.fromIterable(() -> reader.lines().iterator()),
                reader -> reader.close()
        );
//                .map(line -> Observable.fromArray(line.split(pattern)));
    }

    public void get(String filename, String pattern) {
//        try {
//            new BufferedReader(new FileReader(this.getClass().getClassLoader().getResource(filename).getFile()));
//            Observable.create(emitter -> {
//               String line;
//               while()
//            });
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public static Observable<String> fromBufferedReader(BufferedReader reader) {
        return Observable.create(e -> {
            String line;
            while (!e.isDisposed() && (line = reader.readLine()) != null) {
                e.onNext(line);
            }
            e.onComplete();
        });
    }
}
