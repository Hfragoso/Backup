package com.example.admin.w6d2_ex01.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse implements Parcelable {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("info")
    @Expose
    private Info info;
    public final static Creator<ApiResponse> CREATOR = new Creator<ApiResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ApiResponse createFromParcel(Parcel in) {
            ApiResponse instance = new ApiResponse();
            in.readList(instance.results, (Result.class.getClassLoader()));
            instance.info = ((Info) in.readValue((Info.class.getClassLoader())));
            return instance;
        }

        public ApiResponse[] newArray(int size) {
            return (new ApiResponse[size]);
        }

    }
    ;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
        dest.writeValue(info);
    }

    public int describeContents() {
        return  0;
    }

}
