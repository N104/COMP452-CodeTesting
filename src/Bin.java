public class Bin {
    static int[] calculateBinCounts(int[] binEdges, GameStats stats) {
        int[] binCounts = new int[binEdges.length];

        for(int binIndex=0; binIndex<binEdges.length; binIndex++) {
            final int lowerBound = binEdges[binIndex];
            int numGames = 0;

            if (binIndex == binEdges.length - 1) {
                // last bin
                // Sum all the results from lowerBound on up
                for (int numGuesses = lowerBound; numGuesses < stats.maxNumGuesses(); numGuesses++) {
                    numGames += stats.numGames(numGuesses);
                }
            } else {
                int upperBound = binEdges[binIndex + 1];
                for (int numGuesses = lowerBound; numGuesses <= upperBound; numGuesses++) {
                    numGames += stats.numGames(numGuesses);
                }
            }

            binCounts[binIndex] = numGames;
        }
        return binCounts;
    }

    public static String getBinName(int[] binEdges, int binIndex) {
        String binName;
        if(binIndex == binEdges.length-1){
            // last bin
            binName = binEdges[binIndex] + " or more";
        }
        else{
            int upperBound = binEdges[binIndex+1] - 1;
            if(upperBound > binEdges[binIndex]){
                binName = binEdges[binIndex] + "-" + upperBound;
            }
            else{
                binName = Integer.toString(binEdges[binIndex]);
            }
        }
        return binName;
    }
}
