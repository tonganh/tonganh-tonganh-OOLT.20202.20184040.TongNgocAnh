public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    private DigitalVideoDisc itesmOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered < 10){
            for (int i=0; i< qtyOrdered; i++){
                if (itesmOrdered[i] == disc){
                    System.out.println(disc+" Existed");
                    return;
                }
            }
            itesmOrdered[qtyOrdered] = disc;
            qtyOrdered ++;
        } else{
            System.out.println("Error");
        }
    }
    public void showAllListVideoDisc(){
        for (int i=0; i<qtyOrdered;i++){
            System.out.println(itesmOrdered[i].getTitle());
        }
    }
    public float totalCost(){
        float valueReturn =0;
        for (int i = 0; i < qtyOrdered; i++) {
            valueReturn += itesmOrdered[i].getCost();
        }
        return valueReturn;
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for (int i=0; i<qtyOrdered;i++){
            if (itesmOrdered[i] == disc ){
                if (i==qtyOrdered){
                    qtyOrdered--;
                } else{
                    itesmOrdered[i]=itesmOrdered[i+1];
                    qtyOrdered--;
                }
            }
        }
    }
    public static void main(String[] args) {
      Order anOrder = new Order();
      DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King");
      dvd1.setCategory("Animation");
      dvd1.setCost(19.95f);
      dvd1.setDirector("Roger Allers");
      dvd1.setLength((87));

      anOrder.addDigitalVideoDisc(dvd1);
      DigitalVideoDisc dvd2 = new DigitalVideoDisc("Start wars");
      dvd2.setCategory("123");
      dvd2.setCost(24.95f);
      dvd2.setLength(123);
      anOrder.addDigitalVideoDisc(dvd2);
      DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin");
      dvd3.setCategory("tong anh 3");
      dvd3.setCost(18.99f);
      dvd3.setDirector("John Musker");
      dvd3.setLength(90);

//      add the dvd to the order
        anOrder.addDigitalVideoDisc(dvd3);
        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());
    }
}
