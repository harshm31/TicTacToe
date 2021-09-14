package model;

public class Player {
        public String counter;
        public double score;

        public Player(){
            //does nothing
        }

        public Player(String counter,double score) {
            this.counter = counter;
            this.score = score;
        }

        public String getCounter() {
            return counter;
        }

        public void setCounter(String counter) {
            this.counter = counter;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

    public String getSequence() {
        StringBuffer sequence = new StringBuffer();
        for(int i=0;i<3;i++) {
            sequence.append(this.counter);
        }
        return sequence.toString();
    }
}
