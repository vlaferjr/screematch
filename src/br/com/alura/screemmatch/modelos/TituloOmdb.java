package br.com.alura.screemmatch.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public final class TituloOmdb {

    @SerializedName("Title")
    private final String title;
    @SerializedName("Year")
    private final String year;
    @SerializedName("Runtime")
    private final String runtime;


    public TituloOmdb(String title, String year, String runtime) {
        this.title = title;
        this.year = year;
        this.runtime = runtime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, runtime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof TituloOmdb)) {
            return false;
        } else {
            TituloOmdb other = (TituloOmdb) obj;
            return Objects.equals(title, other.title)
                    && Objects.equals(year, other.year)
                    && Objects.equals(runtime, other.runtime);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRuntime() {
        return runtime;
    }
}

