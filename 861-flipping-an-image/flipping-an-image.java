// Flipping an Image
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i = 0 ; i < image.length ; i++) {
            for(int j = 0 , k = image[i].length - 1 ; j <= k ; j++ , k--) {
                int temp = image[i][k];
                image[i][k] = 1 - image[i][j];
                image[i][j] = 1 - temp;
            }
        }
        return image;
    }
}
          