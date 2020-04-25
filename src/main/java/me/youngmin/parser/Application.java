package me.youngmin.parser;

import me.youngmin.parser.dom.ParseDOM;
import me.youngmin.parser.sax.ParseSAX;
import org.openjdk.jmh.annotations.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({ Mode.AverageTime })
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class Application {
    public static void main(String[] args) {
//        withSAXParse100();
//        withSAXParse1000();
    }

    @Benchmark
    public void withSAXParse100() throws Exception {
        ParseSAX handler = new ParseSAX();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse("dummy100.xml", handler);
        System.out.println(handler.getData());
    }

    @Benchmark
    public void withSAXParse1000() throws Exception {
        ParseSAX handler = new ParseSAX();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse("dummy1000.xml", handler);
        System.out.println(handler.getData());
    }

    @Benchmark
    public void withDOMParse100() {
        ParseDOM pd = new ParseDOM();
        pd.parseDOM("dummy100.xml");
        System.out.println(pd.getData());
    }

    @Benchmark
    public void withDOMParse1000() {
        ParseDOM pd = new ParseDOM();
        pd.parseDOM("dummy1000.xml");
        System.out.println(pd.getData());
    }
}
