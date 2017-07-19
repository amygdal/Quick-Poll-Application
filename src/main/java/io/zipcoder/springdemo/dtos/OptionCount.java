package io.zipcoder.springdemo.dtos;

/**
 * Created by leon on 7/18/17.
 */
public class OptionCount {
    private Long optionId;
    private int count;
    // Getters and Setters omitted for brevity

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
