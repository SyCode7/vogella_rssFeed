package sandbox;

public class TryingJSoup {

    public static void main(String[] args) {
        String src = "<description> &lt;div&gt;&lt;p&gt; An independent" +
                " inquiry into the September 11 attack on the US Consulate" +
                " in Benghazi that killed the US ambassador to Libya and" +
                " three other Americans has found that systematic failures" +
                " at the State Department led to â€œgrosslyâ€ inadequate" +
                " security at the mission. &lt;/p&gt;</description>";
//        String unescaped = StringEscapeUtils.unescapeHtml4(src);
//        System.out.println(Jsoup.clean(unescaped, new Whitelist()));
    }

}
