class MicroBlog {
    public String truncate(String input) {
        int[] codePoints = input.codePoints()
            .limit(5)
            .toArray();
        return new String(codePoints, 0, codePoints.length);
    }
}
