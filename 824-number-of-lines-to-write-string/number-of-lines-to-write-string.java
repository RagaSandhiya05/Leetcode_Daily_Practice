class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int noOfLines[] = new int[2];
        int pixel = 0;
        for(char c : s.toCharArray()) {
            int index = c - 'a';
            pixel = pixel + widths[index];
            if(pixel == 100) {
                noOfLines[0]++;
                noOfLines[1] = pixel;
                pixel = 0;
            }
            else if(pixel > 100) {
                noOfLines[0]++;
                pixel = 0;
                pixel = pixel + widths[index];
            }
        }
        if(pixel != 0) {
            noOfLines[0]++;
            noOfLines[1] = pixel;
        }
        return noOfLines;
    }
}
        