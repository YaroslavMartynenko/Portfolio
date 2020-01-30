import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IsinAllocation implements Cloneable {

    private Map<Isin, BigDecimal> isinAllocationMap;

    public IsinAllocation() {
        this.isinAllocationMap = new HashMap<>();
    }

    public Map<Isin, BigDecimal> getIsinAllocationMap() {
        return isinAllocationMap;
    }

    public void setIsinAllocationMap(Map<Isin, BigDecimal> isinAllocationMap) {
        this.isinAllocationMap = isinAllocationMap;
    }

    @Override
    protected IsinAllocation clone() {

        try {
            IsinAllocation clonedIsinAllocation = (IsinAllocation) super.clone();
            Map<Isin, BigDecimal> clonedMap = new HashMap<>();

            for (Map.Entry<Isin, BigDecimal> entry : isinAllocationMap.entrySet()) {
                clonedMap.put(entry.getKey().clone(), entry.getValue());
            }

            clonedIsinAllocation.isinAllocationMap = clonedMap;
            return clonedIsinAllocation;

        } catch (CloneNotSupportedException e) {
            throw new NotCloneableRuntimeException("Cloneable not implemented!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsinAllocation that = (IsinAllocation) o;
        return Objects.equals(isinAllocationMap, that.isinAllocationMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isinAllocationMap);
    }

    public void addNewIsinAndItsAllocationtoMap(Isin isin, BigDecimal allocation) {

        if (!isinAllocationMap.containsKey(isin)) {
            BigDecimal index = (new BigDecimal(100.0).subtract(allocation)).divide(new BigDecimal(100.0));

            for (Map.Entry<Isin, BigDecimal> entry : isinAllocationMap.entrySet()) {
                entry.setValue(entry.getValue().multiply(index));
            }
            isinAllocationMap.put(isin, allocation);
            return;
        }

        isinAllocationMap.remove(isin);
        BigDecimal temporaryIndex = isinAllocationMap.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal index = (new BigDecimal(100.0).subtract(allocation)).divide(temporaryIndex);

        for (Map.Entry<Isin, BigDecimal> entry : isinAllocationMap.entrySet()) {
            entry.setValue(entry.getValue().multiply(index));
        }

        isinAllocationMap.put(isin, allocation);
    }
}
