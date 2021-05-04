package com.example.makananku

import java.util.ArrayList

object FoodsData {

     val foodNames= arrayOf ("Toast ",
   "Scrambled Egg",
    "Hotdog",
    "Fried Rice + Noodle",
    "Lunch Beverage",
    "Honey Pancake",
    "Cheese Pasta",
    "Indonesian Satai",
    "Spaghetti Bolognese",
    "Japanese Sushi")

    private val foodDetails = arrayOf("Bread that is made by baking at a stable temperature and also with a secret recipe. So that can make a unique taste, this toast is served in the morning along with a glass of tea",
    "Scrambled eggs is a dish made from eggs (usually chicken eggs) stirred, whipped or beaten together while being gently heated, typically with salt, butter and sometimes other ingredients.",
    "food consisting of a grilled or steamed sausage served in the slit of a partially sliced bun. It can also refer to the sausage itself. The sausage used is a wiener",
    "food made by re-cooking rice and noodles with a special choice of recipes added to give a delicious taste, this food is from Indonesia and they called  Nasi Mawut",
    "The lunch package is prepared with burgers, fries and sauce variants so that it makes your lunch feel more delicious and full",
    "A pancake is a thin, flat, circular piece of cooked batter made from milk, flour, and eggs. Pancakes are often rolled up or folded and eaten hot with a sweet or savoury filling inside.",
    "is a type of food typically made from an unleavened dough of wheat flour mixed with water or eggs, and formed into sheets or other shapes, then cooked by boiling or baking. Rice flour, or legumes such as beans or lentils, are sometimes used in place of wheat flour to yield a different taste and texture, or as a gluten-free alternative.",
    " is a Southeast Asian dish of seasoned, skewered and grilled meat, served with a sauce. Originating from Indonesian cuisine, satay may consist of diced or sliced chicken, goat, mutton, beef, pork, fish, other meats, or tofu; bamboo skewers are often used, while rustic style of preparations employ skewers from the midrib of the coconut palm frond.",
    "The food was Being or served with a sauce containing meat, tomatoes and other vegetables, and often wine and cream",
    " A type of Japanese food consisting of squares or balls of cold boiled rice, with small pieces of other food, especially raw fish, on top or rolled inside.")

     val foodImages = intArrayOf(R.drawable.bread,
    R.drawable.egg,
    R.drawable.hotdog,
    R.drawable.noodle,
    R.drawable.lunch,
    R.drawable.pancake,
    R.drawable.pasta,
    R.drawable.satai,
    R.drawable.spaghetti,
    R.drawable.sushi)


    val listData: ArrayList<makanan>
    get() {
        val list = arrayListOf<makanan>()
        for (position in foodNames.indices) {
            val Makanan = makanan()
            Makanan.name = foodNames[position]
            Makanan.detail = foodDetails[position]
            Makanan.photo = foodImages [position]
            list.add(Makanan)
        }
        return list
    }
}