package neresources.api.distributions;

import neresources.api.utils.DistributionHelpers;

public class DistributionTriangular extends DistributionBase
{
    /**
     * @param midY top of the triangular distribution
     * @param range length of the sides
     * @param maxChance chance at the top
     */
    public DistributionTriangular(int midY, int range, double maxChance)
    {
        super(DistributionHelpers.getTriangularDistribution(midY, range, maxChance));
        this.bestHeight = midY;
    }
}
