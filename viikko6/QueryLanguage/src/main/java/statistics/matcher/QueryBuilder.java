package statistics.matcher;


public class QueryBuilder {

    private Matcher m;


    public QueryBuilder() {
        m = new All();
    }

    public Matcher build() {
        Matcher m1 = m;
        m=new All();
        return m1;
    }

    public QueryBuilder playsIn(String team) {
        Matcher m1 = new PlaysIn(team);
        m = new And(m, m1);
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        Matcher m1 = new HasFewerThan(value, category);
        m = new And(m, m1);
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        Matcher m1 = new HasAtLeast(value, category);
        m = new And(m, m1);
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        m = new Or(matchers);
        return this;

    }

}
