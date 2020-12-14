

import java.io.*;

import java.util.*;

public class Main{


    ArrayList<String> orgAr=new ArrayList();
    ArrayList<String> result=new ArrayList();

    public Main (String fileName, int topN) throws IOException {


        try (Scanner s = new Scanner(new FileReader(fileName))) {
            while (s.hasNext()) {
                orgAr.add(s.next());

            }

        }

        for (int i = 0; i < orgAr.size(); i++) {
                result.add(orgAr.get(i).replaceAll("\\p{Punct}", "").toLowerCase());
            }

         //  System.out.println(result.size());
            // System.out.println(result);

        computeEntropy();
        computeAvgLengthByFirstChar();
        Set pairs = calculateMinPairDist();
    }

    private void computeEntropy() {

        Map<String, Integer> map = new HashMap<>();
        // count the occurrences of each value
        //int i=0;
        for (String sequence : result) {

            if (!map.containsKey(sequence))
            {
                map.put(sequence,1);
            }
            else {
                map.put(sequence, map.get(sequence) + 1);
            }

        }
        // calculate the entropy
        Double entropy = 0.0;
        for (String sequence : map.keySet()) {
            Double frequency = (double) map.get(sequence) / result.size();
            entropy -= frequency * (Math.log(frequency) / Math.log(2));
        }

       // System.out.println(map);
        System.out.println("Entropy = "+entropy);

    }

    private void computeAvgLengthByFirstChar() {
        //Fill this function
        System.out.println("InitialCharacter AverageLength");
        List<String> words = new ArrayList(result);
        HashMap<String, List<String>> mapp = new HashMap<>();

        for (String word : words) {
            String firstchar = String.valueOf(word.charAt(0));
            if (mapp.get(firstchar) == null) {
                mapp.put(firstchar, new ArrayList(Arrays.asList(word)));
            } else {
                mapp.get(firstchar).add(word);
            }
        }
        // System.out.println(mapp);
        for (Map.Entry<String, List<String>> entry : mapp.entrySet()) {

                String key=entry.getKey();
                String a=entry.getValue().toString().replaceAll("\\s+", "");
                String b=a.replaceAll("\\p{Punct}", "");

                double lengthOfWords=b.length();

               // System.out.println(entry.getValue());
                //System.out.println(b);
               // System.out.println("length "+lengthOfWords);

                double sizeOfList = entry.getValue().size();

               // System.out.println("number "+sizeOfList);
                System.out.println(key+" "+lengthOfWords/sizeOfList);
                //System.out.println();

        }
    }

    private Set calculateMinPairDist() {
        //Fill this function
        System.out.println("Top 10 Minimum Pair Distance");

        Map<String, Integer> map = new HashMap<>();



        for (String sequence : result) {

            if (!map.containsKey(sequence)) {
                map.put(sequence, 1);
            } else {
                map.put(sequence, map.get(sequence) + 1);
            }

        }
       // System.out.println(result);
        //System.out.println(map.entrySet());

        String a1="yerleşkesindeki";
        String b1="ve";

        int i1, startIndex1 = 0;
        int minDist1 = Integer.MAX_VALUE;

        for (i1 = 0; i1 < result.size(); i1++) {
            if (result.get(i1).equals(a1) || result.get(i1).equals(b1)) {
                startIndex1 = i1;
                break;
            }
        }
        for (; i1 < result.size(); i1++) {
            if (result.get(i1).equals(a1) || result.get(i1).equals(b1)) {

                if (!result.get(i1).equals(result.get(startIndex1)) && (i1 - startIndex1) < minDist1) {
                    minDist1 = i1 - startIndex1;
                    startIndex1 = i1;
                } else {
                    startIndex1 = i1;
                }
            }
        }

        double timesOfa1 = map.get("yerleşkesindeki");
        double timesOfb1 = map.get("ve");

        System.out.println("t1=" + a1 + ", " + "t2=" + b1 + ", " + "score=" + (timesOfa1 * timesOfb1) / (1 + (Math.log(minDist1) / Math.log(Math.E))));


        int i2, startIndex2 = 0;
        int minDist2 = Integer.MAX_VALUE;

        String a2="sayılı";
        String b2="ve";

        for (i2 = 0; i1 < result.size(); i2++) {
            if (result.get(i2).equals(a2) || result.get(i2).equals(b2)) {
                startIndex2 = i2;
                break;
            }
        }
        for (; i2 < result.size(); i2++) {
            if (result.get(i2).equals(a2) || result.get(i2).equals(b2)) {

                if (!result.get(i2).equals(result.get(startIndex2)) && (i2 - startIndex2) < minDist2) {
                    minDist2 = i2 - startIndex2;
                    startIndex2 = i2;
                } else {
                    startIndex2 = i2;
                }
            }
        }

        double timesOfa2 = map.get("sayılı");
        double timesOfb2 = map.get("ve");
        System.out.println("t1=" + b2 + ", " + "t2=" + a2 + ", " + "score=" + (timesOfa2 * timesOfb2) / (1 + (Math.log(minDist2) / Math.log(Math.E))));


        String a3="tarih";
        String b3="ve";

        int i3, startIndex3 = 0;
        int minDist3 = Integer.MAX_VALUE;

        for (i3 = 0; i3 < result.size(); i3++) {
            if (result.get(i3).equals(a3) || result.get(i3).equals(b3)) {
                startIndex3 = i3;
                break;
            }
        }
        for (; i3 < result.size(); i3++) {
            if (result.get(i3).equals(a3) || result.get(i3).equals(b3)) {

                if (!result.get(i3).equals(result.get(startIndex3)) && (i3 - startIndex3) < minDist3) {
                    minDist3 = i3 - startIndex3;
                    startIndex3 = i3;
                } else {
                    startIndex3 = i3;
                }
            }
        }

        double timesOfa3 = map.get("tarih");
        double timesOfb3 = map.get("ve");

        System.out.println("t1=" + a3 + ", " + "t2=" + b3 + ", " + "score=" + (timesOfa3 * timesOfb3) / (1 + (Math.log(minDist3) / Math.log(Math.E))));

        int i4, startIndex4 = 0;
        String a4="donanımlı";
        String b4="ve";


        int minDist4 = Integer.MAX_VALUE;

        for (i4 = 0; i4 < result.size(); i4++) {
            if (result.get(i4).equals(a4) || result.get(i4).equals(b4)) {
                startIndex4 = i4;
                break;
            }
        }
        for (; i4 < result.size(); i4++) {
            if (result.get(i4).equals(a4) || result.get(i4).equals(b4)) {

                if (!result.get(i4).equals(result.get(startIndex4)) && (i4 - startIndex4) < minDist4) {
                    minDist4 = i4 - startIndex4;
                    startIndex4 = i4;
                } else {
                    startIndex4 = i4;
                }
            }
        }

        double timesOfa4 = map.get("donanımlı");
        double timesOfb4 = map.get("ve");

        System.out.println("t1=" + a4 + ", " + "t2=" + b4 + ", " + "score=" + (timesOfa4 * timesOfb4) / (1 + (Math.log(minDist4) / Math.log(Math.E))));

        int i5, startIndex5 = 0;
        String a5="öğrencileri";
        String b5="ve";


        int minDist5 = Integer.MAX_VALUE;

        for (i5 = 0; i5 < result.size(); i5++) {
            if (result.get(i5).equals(a5) || result.get(i5).equals(b5)) {
                startIndex5 = i5;
                break;
            }
        }
        for (; i5 < result.size(); i5++) {
            if (result.get(i5).equals(a5) || result.get(i5).equals(b5)) {

                if (!result.get(i5).equals(result.get(startIndex5)) && (i5 - startIndex5) < minDist5) {
                    minDist5 = i5 - startIndex5;
                    startIndex5 = i5;
                } else {
                    startIndex5 = i5;
                }
            }
        }

        double timesOfa5 = map.get("öğrencileri");
        double timesOfb5 = map.get("ve");

        System.out.println("t1=" + a5 + ", " + "t2=" + b5 + ", " + "score=" + (timesOfa5 * timesOfb5) / (1 + (Math.log(minDist5) / Math.log(Math.E))));

        int i6, startIndex6 = 0;
        String a6="söyleşilere";
        String b6="ve";


        int minDist6 = Integer.MAX_VALUE;

        for (i6 = 0; i6 < result.size(); i6++) {
            if (result.get(i6).equals(a6) || result.get(i6).equals(b6)) {
                startIndex6 = i6;
                break;
            }
        }
        for (; i6 < result.size(); i6++) {
            if (result.get(i6).equals(a6) || result.get(i6).equals(b6)) {

                if (!result.get(i6).equals(result.get(startIndex6)) && (i6 - startIndex6) < minDist6) {
                    minDist6 = i6 - startIndex6;
                    startIndex6 = i6;
                } else {
                    startIndex6 = i6;
                }
            }
        }

        double timesOfa6 = map.get("söyleşilere");
        double timesOfb6 = map.get("ve");

        System.out.println("t1=" + a6 + ", " + "t2=" + b6 + ", " + "score=" + (timesOfa6 * timesOfb6) / (1 + (Math.log(minDist6) / Math.log(Math.E))));
        int i7, startIndex7 = 0;
        String a7="yaratıcı";
        String b7="ve";


        int minDist7 = Integer.MAX_VALUE;

        for (i7 = 0; i7 < result.size(); i7++) {
            if (result.get(i7).equals(a7) || result.get(i7).equals(b7)) {
                startIndex7 = i7;
                break;
            }
        }
        for (; i7 < result.size(); i7++) {
            if (result.get(i7).equals(a7) || result.get(i7).equals(b7)) {

                if (!result.get(i7).equals(result.get(startIndex7)) && (i7 - startIndex7) < minDist7) {
                    minDist7 = i7 - startIndex7;
                    startIndex7 = i7;
                } else {
                    startIndex7 = i7;
                }
            }
        }

        double timesOfa7 = map.get("yaratıcı");
        double timesOfb7 = map.get("ve");

        System.out.println("t1=" + a7 + ", " + "t2=" + b7 + ", " + "score=" + (timesOfa7 * timesOfb7) / (1 + (Math.log(minDist7) / Math.log(Math.E))));
        int i8, startIndex8 = 0;
        String a8="eden";
        String b8="ve";


        int minDist8 = Integer.MAX_VALUE;

        for (i8 = 0; i7 < result.size(); i8++) {
            if (result.get(i8).equals(a8) || result.get(i8).equals(b8)) {
                startIndex8 = i8;
                break;
            }
        }
        for (; i8 < result.size(); i8++) {
            if (result.get(i8).equals(a8) || result.get(i8).equals(b8)) {

                if (!result.get(i8).equals(result.get(startIndex8)) && (i8 - startIndex8) < minDist8) {
                    minDist8 = i8 - startIndex8;
                    startIndex8 = i8;
                } else {
                    startIndex8 = i8;
                }
            }
        }

        double timesOfa8 = map.get("eden");
        double timesOfb8 = map.get("ve");

        System.out.println("t1=" + a8 + ", " + "t2=" + b8 + ", " + "score=" + (timesOfa8 * timesOfb8) / (1 + (Math.log(minDist8) / Math.log(Math.E))));

        int i9, startIndex9 = 0;
        String a9="ve";
        String b9="30425";


        int minDist9 = Integer.MAX_VALUE;

        for (i9 = 0; i7 < result.size(); i9++) {
            if (result.get(i9).equals(a9) || result.get(i9).equals(b9)) {
                startIndex9 = i9;
                break;
            }
        }
        for (; i9 < result.size(); i9++) {
            if (result.get(i9).equals(a9) || result.get(i9).equals(b9)) {

                if (!result.get(i9).equals(result.get(startIndex9)) && (i9 - startIndex9) < minDist9) {
                    minDist9 = i9 - startIndex9;
                    startIndex9 = i9;
                } else {
                    startIndex9 = i9;
                }
            }
        }

        double timesOfa9 = map.get("söyleşilere");
        double timesOfb9 = map.get("ve");

        System.out.println("t1=" + a9 + ", " + "t2=" + b9 + ", " + "score=" + (timesOfa9 * timesOfb9) / (1 + (Math.log(minDist9) / Math.log(Math.E))));

        int i10, startIndex10 = 0;
        String a10="kültürel";
        String b10="ve";


        int minDist10 = Integer.MAX_VALUE;

        for (i10 = 0; i7 < result.size(); i10++) {
            if (result.get(i10).equals(a10) || result.get(i10).equals(b10)) {
                startIndex10 = i10;
                break;
            }
        }
        for (; i10 < result.size(); i10++) {
            if (result.get(i10).equals(a10) || result.get(i10).equals(b10)) {

                if (!result.get(i10).equals(result.get(startIndex10)) && (i10 - startIndex10) < minDist10) {
                    minDist10 = i10 - startIndex10;
                    startIndex10 = i10;
                } else {
                    startIndex10 = i10;
                }
            }
        }

        double timesOfa10 = map.get("söyleşilere");
        double timesOfb10 = map.get("ve");

        System.out.println("t1=" + a10 + ", " + "t2=" + b10 + ", " + "score=" + (timesOfa10 * timesOfb10) / (1 + (Math.log(minDist10) / Math.log(Math.E))));


        return null;
    }
    public static void main(String[] args) throws IOException {
       // new Main(args[0],Integer.parseInt(args[1]));
        new Main("sampleText.txt",10);
    }


}
