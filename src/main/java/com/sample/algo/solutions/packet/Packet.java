package com.sample.algo.solutions.packet;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author manyce400
 */
public class Packet implements Comparable<Packet> {


    private SourceTypeE sourceType;

    private boolean isLarge;

    private long creationTime;

    public Packet(SourceTypeE sourceType, boolean isLarge) {
        this.sourceType = sourceType;
        this.isLarge = isLarge;
        this.creationTime = System.currentTimeMillis();
    }

    public SourceTypeE getSourceType() {
        return sourceType;
    }

    public boolean isLarge() {
        return isLarge;
    }

    public long getCreationTime() {
        return creationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Packet packet = (Packet) o;

        return new EqualsBuilder()
                .append(isLarge, packet.isLarge)
                .append(sourceType, packet.sourceType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(sourceType)
                .append(isLarge)
                .append(creationTime)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("sourceType", sourceType)
                .append("isLarge", isLarge)
                .append("creationTime", creationTime)
                .toString();
    }

    @Override
    public int compareTo(Packet o) {
        if(o != null) {
            Packet other = (Packet) o;
            SourceTypeE otherSourceType = other.getSourceType();
            boolean otherIsLarge = other.isLarge;

            // Base case Management Packet's have higher priority
            if(sourceType == SourceTypeE.Management && otherSourceType != SourceTypeE.Management) {
                return 1;
            } else if(otherSourceType == SourceTypeE.Management && sourceType != SourceTypeE.Management) {
                return -1;
            } else {
                // isLarge takes precedence
                if(isLarge == true && otherIsLarge == false) {
                    return 1;
                } else if(otherIsLarge == true &&  isLarge == false) {
                    return -1;
                }
            }
        }

        return 0;
    }

    public static Packet newInstanceManagement(boolean isLarge) {
        return new Packet(SourceTypeE.Management, isLarge);
    }

    public static Packet newInstanceUser(boolean isLarge) {
        return new Packet(SourceTypeE.User, isLarge);
    }

}
