package entity;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;

    @Entity
    @Table
    public class Exchange {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @SerializedName("r030")
        private int excheId;
        private String txt;
        private double rate;
        @SerializedName("cc")
        private String excheName;
        private String exchangedate;


        public Exchange() {
        }

        public Exchange(int id, int excheId, String txt, double rate, String excheName, String exchangedate) {
            this.id = id;
            this.excheId = excheId;
            this.txt = txt;
            this.rate = rate;
            this.excheName = excheName;
            this.exchangedate = exchangedate;
        }

        public Exchange(int excheId, String txt, double rate, String excheName, String exchangedate) {
            this.excheId = excheId;
            this.txt = txt;
            this.rate = rate;
            this.excheName = excheName;
            this.exchangedate = exchangedate;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getExcheId() {
            return excheId;
        }

        public void setExcheId(int excheId) {
            this.excheId = excheId;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }

        public String getExcheName() {
            return excheName;
        }

        public void setExcheName(String excheName) {
            this.excheName = excheName;
        }

        public String getExchangedate() {
            return exchangedate;
        }

        public void setExchangedate(String exchangedate) {
            this.exchangedate = exchangedate;
        }

        @Override
        public String toString() {
            return "Exchange{" +
                    "id=" + id +
                    ", excheId=" + excheId +
                    ", txt='" + txt + '\'' +
                    ", rate=" + rate +
                    ", excheName='" + excheName + '\'' +
                    ", exchangedate='" + exchangedate + '\'' +
                    '}';
        }
    }
