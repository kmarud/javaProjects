
public class ProgramFactory {
    public void testFunction()
    {
        MyCustomList<String> sample = new MyCustomList<>();
        System.out.println("przed:\n");
        sample.add("Ala");
        sample.add("ma");
        sample.add("kota");
        sample.add("a");
        sample.add("kot");
        sample.add("ma");
        sample.add("Ale");

        for (int i =0; i < sample.size(); i++)
            System.out.println(sample.get(i));

        sample.remove("a");
        sample.remove("Ale");
        int index = sample.findFirst("kot");
        sample.removeIndex(index);
        sample.removeIndex(3);

        sample.add("psa");
        index = sample.findFirst("kota");
        sample.replace(index, 3);
        sample.remove("kota");
        System.out.println("\npo:\n");
        for (int i =0; i < sample.size(); i++)
            System.out.println(sample.get(i));
    }
}
