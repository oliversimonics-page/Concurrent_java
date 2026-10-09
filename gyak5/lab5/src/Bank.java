public class Bank {
        public int egyenleg;
        public Bank(){
        }
        public synchronized void addLoan(int amount){
            egyenleg += amount;
        }
    }
