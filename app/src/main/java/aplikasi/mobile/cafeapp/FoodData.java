package aplikasi.mobile.cafeapp;

import android.content.Context;

import aplikasi.mobile.cafeapp.R;

import java.util.ArrayList;

public class FoodData {

    public static ArrayList<Integer> getImage() {
        ArrayList<Integer> drawables = new ArrayList<Integer>();
        drawables.add(R.drawable.batagor);
        drawables.add(R.drawable.black_salad);
        drawables.add(R.drawable.cappuchino);
        drawables.add(R.drawable.cheesecake);
        drawables.add(R.drawable.cireng);
        drawables.add(R.drawable.donut);
        drawables.add(R.drawable.kopi_hitam);
        drawables.add(R.drawable.nasigoreng);

        return drawables;
    }

    public static ArrayList<Food> getData(Context context) {
        ArrayList<Food> list = new ArrayList<Food>();
        list.add(new Food(
                "Batagor",
                "Batagor merupakan nama makanan dari singkatan bakso, tahu, dan goreng. Makanan khas Sunda ini adalah adaptasi dari hidangan Tionghoa-Indonesia.",
                "Rp 5000",
                context.getDrawable(R.drawable.batagor)));
        list.add(new Food(
                "Black Salad",
                "Black Salad terbuat dari charcoal alias arang, salad ini pakai saus manis sama keju. Saus manisnya bikin dari mayo dan ada resep rahasianya juga.",
                "Rp 10000",
                context.getDrawable(R.drawable.black_salad)));
        list.add(new Food(
                "Bagi Cappuchino",
                "Cappuccino merupakan kopi yang populer dari Italia karena lebih sering dan lebih banyak dikonsumsi. Rasanya yang tidak terlalu pahit seperti espresso, membuat cappuccino lebih mudah diterima oleh lidah semua orang khususnya kalangan muda. Komposisinya terdiri atas espresso dan tambahan susu cair serta busa di atasnya. Ada juga beberapa orang suka mengganti susu dengan bubuk cokelat atau bubuk kayu manis.",
                "Rp 15000",
                context.getDrawable(R.drawable.cappuchino)));
        list.add(new Food(
                "Cheesecake",
                "Cheesecake adalah produk pastry yang cukup unik karena teksturnya yang lembut, tetapi bukan mousse, padat tapi bukan jenis sponge, maka cheesecake tidak dapat dikategorikan dalam satu jenis pastry.",
                "Rp 6000",
                context.getDrawable(R.drawable.cheesecake)));
        list.add(new Food(
                "Cireng",
                "Cireng adalah makanan ringan yang berasal dari Provinsi Jawa Barat. Kata cireng adalah singkatan dari ‘aci digoreng’ yang dalam bahasa Indonesia berarti tepung kanji goreng.",
                "Rp 5000",
                context.getDrawable(R.drawable.cireng)));
        list.add(new Food(
                "Rainbow Donat",
                "Donat adalah penganan yang digoreng, dibuat dari adonan tepung terigu, gula, telur, dan mentega. Donat yang paling umum adalah donat berbentuk cincin dengan lubang di tengah dan donat berbentuk bundar dengan isian manis, seperti selai, jelly, krim, dan custard.",
                "Rp 3000",
                context.getDrawable(R.drawable.donut)));
        list.add(new Food(
                "Bagi Kopi Arabika",
                "Kopi arabika merupakan salah satu dari beragam jenis kopi yang dibudidayakan secara global. Dibandingkan dengan berbagai jenis kopi lainnya, kopi arabika termasuk kopi yang memiliki nilai tertinggi di seluruh dunia. Hal ini disebabkan oleh cita rasa berbeda yang dihasilkan oleh setiap varietasnya sehingga para pencinta kopi punya banyak pilihan rasa.",
                "Rp 15000",
                context.getDrawable(R.drawable.kopi_hitam)));
        list.add(new Food(
                "Nasi Goreng",
                "Nasi goreng adalah sebuah makanan berupa nasi yang digoreng dan diaduk dalam minyak goreng, margarin, atau mentega. Biasanya ditambah kecap manis, bawang merah, bawang putih, asam jawa, lada dan bumbu-bumbu lainnya; seperti telur, ayam, dan kerupuk. Ada pula nasi goreng jenis lain yang dibuat bersama ikan asin yang juga populer di seluruh Indonesia.",
                "Rp 12000",
                context.getDrawable(R.drawable.cireng)));
        return list;
    }
}
