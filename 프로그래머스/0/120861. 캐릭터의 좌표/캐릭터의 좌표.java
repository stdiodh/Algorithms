class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int widthMid = board[0] / 2;
        int heightMid = board[1] / 2;
        int x = 0;
        int y = 0;
        
        for(int i=0; i < keyinput.length; i++){
            String input = keyinput[i];
            
            if(input.equals("left")){
                if(-widthMid >= x){
                    continue;
                }
                x -= 1;
            }
            if(input.equals("right")){
                if(widthMid <= x){
                    continue;
                }
                x += 1;
            }
            if(input.equals("up")){
                if(heightMid <= y){
                    continue;
                }
                y += 1;
            }
            if(input.equals("down")){
                if(-heightMid >= y){
                    continue;
                }
                y -= 1;
            }
        }
        
        int[] positive = {x, y};
        
        return positive;
    }
}