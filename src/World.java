
import java.util.ArrayList;
public class World {


        static ArrayList<ArrayList<String>> MapOfBiomes = new ArrayList<ArrayList<String>>(); // 2d arraylist map
        static int ChunkLength = 20; //width of chunk area x*x = chunksize
        static int PlayerX = 2; // where player is x
        static int PlayerY = 2; // where player is y
        static String placeholder = "-";
        static int test = 0;

        public static void CheckGenerate()
        {
            for(int i = 0; i< MapOfBiomes.size();i++)
            {
                for(int j = 0; j<MapOfBiomes.get(i).size();j++) {
                    if (PlayerX==j && PlayerY==i) {

                        if (i == 0) {
                            if (j != 0 && j != MapOfBiomes.get(i).size() - 1) {


                            } else {
                                if (j == 0) {

                                }

                                if (j == MapOfBiomes.get(i).size() - 1) {

                                }
                            }
                        }

                        if (i == MapOfBiomes.size() - 1) { //bottom no corner

                            if (j != 0 && j != MapOfBiomes.get(i).size() - 1)
                            {

                                MapOfBiomes.add(new ArrayList<>());

                                for(int k = 0; k<MapOfBiomes.get(i-1).size() ; k++) {
                                    if (k == PlayerX - 1 || k == PlayerX || k == PlayerX + 1) {

                                        test++;
                                        MapOfBiomes.get(MapOfBiomes.size() - 1).add(k, Integer.toString(test));

                                    } else {
                                        MapOfBiomes.get(MapOfBiomes.size() - 1).add(placeholder);
                                    }
                                }

                            } else {

                                if (j == 0) {

                                }

                                if (j == MapOfBiomes.get(i).size() - 1) { //bottom right corner

                                    System.out.println("hey");
                                    MapOfBiomes.add(new ArrayList<>());

                                    for(int k = 0; k<MapOfBiomes.get(i-1).size() ; k++)
                                    {
                                        if( k==PlayerX)
                                        {

                                            test++;
                                            MapOfBiomes.get(MapOfBiomes.size()-1).add(k,Integer.toString(test));
                                            test++;
                                            MapOfBiomes.get(MapOfBiomes.size()-1).add(k+1,Integer.toString(test));

                                        } else
                                        {
                                            MapOfBiomes.get(MapOfBiomes.size()-1).add(placeholder);
                                        }

                                    }

                                    if(PlayerX==MapOfBiomes.get(PlayerY).size()-1)
                                    {
                                        test++;
                                        MapOfBiomes.get(PlayerY).add(PlayerX+1, String.valueOf(test));
                                    }

                                    if(PlayerX==MapOfBiomes.get(PlayerY-1).size()-1)
                                    {
                                        test++;
                                        MapOfBiomes.get(PlayerY-1).add(PlayerX+1, String.valueOf(test));
                                    }

                                }

                            }



                        }
                    }
                }
                System.out.println();
            }

            if(PlayerX>0 && MapOfBiomes.get(PlayerY).get(PlayerX-1).equals(placeholder))
            {
                test++;
                MapOfBiomes.get(PlayerY).set(PlayerX-1, String.valueOf(test));
            }

            if(PlayerX>0 && PlayerY < MapOfBiomes.size()-1 && MapOfBiomes.get(PlayerY-1).get(PlayerX-1).equals(placeholder))
            {
                test++;
                MapOfBiomes.get(PlayerY+1).set(PlayerX-1, String.valueOf(test));
            }
        }



        public static void SetUp()
        {

            for(int i = 0; i<3; i++)
            {
                MapOfBiomes.add(new ArrayList<>());
                for(int j = 0; j < 3; j++)
                {
                    test++;
                    MapOfBiomes.get(i).add(j,Integer.toString(test));
                }
            }
            CheckGenerate();
            print();
        }

        public static void print()
        {

            for(int i = 0; i< MapOfBiomes.size();i++)
            {
                for(int j = 0; j<MapOfBiomes.get(i).size();j++)
                {
                    System.out.print(MapOfBiomes.get(i).get(j)+ "  ");
                }
                System.out.println();
            }

            System.out.println();

            for(int i = 0; i< MapOfBiomes.size();i++)
            {
                for(int j = 0; j<MapOfBiomes.get(i).size();j++)
                {
                    System.out.print((j+","+i)+"  ");
                }
                System.out.println();
            }

            System.out.println();

            System.out.println(MapOfBiomes);
        }

        public static void main(String[] args) {
            SetUp();

            PlayerY++;
            CheckGenerate();
            print();
        }

    }

}
