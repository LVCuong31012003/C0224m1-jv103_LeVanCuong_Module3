package Model;

import java.util.ArrayList;
import java.util.List;

public class BookingCard {
    private List<BookingCardIteam> bookingcardItemList;

    public BookingCard() {

        this.bookingcardItemList = new ArrayList<>();
    }

    public void Add(BookingCardIteam bookingcardIteam) {
        for (BookingCardIteam i : bookingcardItemList) {
            if (i.getStudent().getStudent_id() == bookingcardIteam.getStudent().getStudent_id()) {
                i.addQuanlity(1);
                return;
            }
            this.bookingcardItemList.add(bookingcardIteam);
        }
    }
        public void remove ( int id){
            for (BookingCardIteam c : bookingcardItemList) {
                if (c.getStudent().getStudent_id() == id) {
                    bookingcardItemList.remove(c);
                    return;
                }
            }
        }

        public void update ( int id, int quanlity){
            for (BookingCardIteam c : bookingcardItemList) {
                if (c.getStudent().getStudent_id() == id) {
                    c.setQuanlity(quanlity);
                    return;
                }
            }
        }
        public int getSize () {
            int re = 0;
            for (BookingCardIteam c : bookingcardItemList) {
                re += c.getQuanlity();
            }
            return re;
        }
        public List<BookingCardIteam> getCartItemList () {
            return this.bookingcardItemList;
        }
    }
