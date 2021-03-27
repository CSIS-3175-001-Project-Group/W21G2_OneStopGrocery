package com.example.onestopgrocery.initdata;

import com.example.onestopgrocery.R;
import com.example.onestopgrocery.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
    private List<Product> productList;

    public ProductData() {
        this.productList = new ArrayList<>();
    }

    public void init() {
        this.productList.add(new Product("Eggs White", "Super white and health Farm Land, 0.33c, 12x", 0f, 3.96d, 0.300f, R.drawable.eggs_white));
        this.productList.add(new Product("Eggs Brown", "Brown health, no GMO, 0.31c, 6x", 3.2f, 1.86d, 0.150f, R.drawable.eggs_brown));
        this.productList.add(new Product("Broccoli Florets (Frozen)", "Crunchy, bright green and versatile, broccoli is " +
                "a part of the cabbage family. Its mild flavor and texture makes it a perfect addition to stir-fry, curries, pastas and soups." +
                " It’s also delicious on its own or as a side dish, paired with lemon or butter.", 4.5f, 3.99d, 0.100f, R.drawable.frozen_broccoli_1));
        this.productList.add(new Product("Cauliflower (Frozen)", "Having a stash of frozen veg. means that you'll always have" +
                " on hand a source of veggies that won’t easily go to waste! Fully prepared, this frozen cauliflower is ready to conveniently slip into a quick weeknight" +
                " meal, adding a velvety texture to soup or shining through on its own in dishes like aloo gobi. Rich in fibre, vitamin C, and vitamin K; cauliflower also " +
                "makes a nutrient-dense substitute for starches such as mashed potatoes, tabouli, and rice.", 3.9f, 3.99d, 0.350f, R.drawable.frozen_cauliflower_1));
        this.productList.add(new Product("Corn (Frozen)", "A product of earth-friendly farming, Stahlbush super-sweet whole kernel corn has undergone strict" +
                " tests that indicate no detectable pesticide residue. Great for soups, stews, lasagne, or by itself as a delicious side dish!", 5f, 3.99d, 0.350f, R.drawable.frozen_corn_1));
        this.productList.add(new Product("Cut Rainbow Chard (Frozen)", "One of our most colorful vegetables, Rainbow Chard is such a treat to see and enjoy!" +
                " This vibrant vegetable is a great addition to any meal that needs a little extra green. Make it the star of your dish by incorporating it into a salad or" +
                " sautéing it for the base of your meal, or sneak it into sandwiches, soup, or even pizza for a more subtle addition.", 0f, 3.99d, 0.300f, R.drawable.frozen_chard_1));
        this.productList.add(new Product("Cut Spinach (Frozen)", "Each leaf is frozen individually not in a large clump." +
                " If you do not use it all at once, the rest can go back into the freezer for next time.", 3.4f, 3.99d, 0.300f, R.drawable.frozen_cut_spinach_1));
        this.productList.add(new Product("Diced Sweet Potato (Frozen)", "Naturally high in sugars and vitamin A, sweet potatoes" +
                " are one of those rare vegetables that can be prepared in either sweet or savory dishes. Sweet potatoes are a popular addition to" +
                " breakfast hashes and casseroles. They pair nicely with brown sugar, maple syrup or rosemary.", 5f, 3.99d, 0.284f, R.drawable.frozen_diced_sweet_potato_1));
        this.productList.add(new Product("Organic Broccoli Florets (Frozen)", "Frozen and delicious, ready for any recipe. This" +
                " product traveled 1646 km to reach our warehouse.", 2.5f, 4.49d, 0.300f, R.drawable.frozen_broccoli_2));
        this.productList.add(new Product("Organic Green Beans (Frozen)", "A frozen garden classic with the flavor and nutrition of fresh." +
                "This product traveled 1646 km to reach our warehouse.", 3.75f, 4.49d, 0.300f, R.drawable.frozen_organic_green_breans_1));

        this.productList.add(new Product("Organic Avocado, Hass", "Creamy, buttery and oh so decadent, avocados are a great addition to any sushi roll, " +
                "sandwich, salad or Mexican dish. They also provide nearly 20 essential nutrients, including Vitamin E, B-Vitamins, folic acid and" +
                " essential fats.", 0f, 0.99d, 0.020f, R.drawable.fruit_avocado));
        this.productList.add(new Product("Organic Bananas", "Bananas are tasty, " +
                "creamy and full of essential nutrients. They are also extremely high in potassium, " +
                "over 467 mg per banana. We enjoy bananas when they're just turning yellow. Slice them " +
                "onto your cereal, blend them into smoothies or just grab-and-go for a nutritious snack. 6x", 3.55f, 3.79d, 0.120f, R.drawable.fruit_banana));
        this.productList.add(new Product("Organic Lemons", "Adding fresh lemon to cooked " +
                "vegetables enhances flavour and increases iron absorbtion. Lemons should be stored in the" +
                " fridge, but brought out to sit at room temperature before using to increase juice content." +
                "This product traveled 2800 km to reach our warehouse. 3x", 4.9f, 2.99d, 0.100f, R.drawable.fruit_lemons));
        this.productList.add(new Product("Local Organic Apples, Bagged Gala", "The Gala apple is one of our most popular apples." +
                " Sweet, juicy and crisp, Galas provide a nutritious on-the-go snack, and work well for baking pies and crumbles. High in Vitamin C" +
                " and fibre too. This product traveled 348 km to reach our warehouse. 1 Bag", 5f, 6.49d, 1.36f, R.drawable.fruit_apples));
        this.productList.add(new Product("Organic Strawberries", "A member of the rose family," +
                " these berries are grown all over the world for their sweet, fragrant flavour. ", 4f, 8.99d, 0.5f, R.drawable.fruit_strawberries));
        this.productList.add(new Product("Organic Oranges, Cara Cara", "The Cara Cara Orange is also known" +
                " as the navel orange, it originated at the Hacienda de Cara Cara in Valencia, Venezuela. 3x", 5f, 4.69d, 0.200f, R.drawable.fruit_oranges));
        this.productList.add(new Product("Organic Raspberries", "One of the more flavorful members of the berry family," +
                " the raspberry is composed of connecting drupelets (individual sections" +
                " of fruit, each with its own seed) surrounding a central core.", 4.24f, 8.99d, 0.450f, R.drawable.fruit_raspberries));
        this.productList.add(new Product("Organic Pineapple", "Pineapples have bumpy," +
                " diamond patterned skins and are juicy and sweet. Use in fresh fruit desserts and salads.", 4f, 8.99d, 1f, R.drawable.fruit_pineapple));
        this.productList.add(new Product("Low Sodium Minestrone Soup", "Filtered Water, Organic Tomatoes," +
                " Organic Onions, Organic Carrots, Organic Kidney Beans, Organic Potatoes, Organic Celery, Organic Green Beans," +
                " Organic Pasta (Organic Semolina Flour, Filterer Water), Organic Peas, Organic Leeks, Spices*, Organic Safflower " +
                "And/Or Sunflower Oil, Sea Salt, Organic Garlic", 4.33f, 3.99d, 0.398f, R.drawable.canned_soup1));
        this.productList.add(new Product("Organic Coconut Cream (BPA & Gum Free)", "Fairtrade Certified," +
                " Certified Organic, Gluten Free, BPA & Gum Free, No added sugar, Preservative and sulphite free," +
                " Non Irradiated, 100% Delicious! 1% of the sales of this product will go towards protecting" +
                " Sri Lanka's wild elephants.", 0f, 5.49d, 0.400f, R.drawable.canned_coconut_cream));

        this.productList.add(new Product("Organic Jellied Cranberry Sauce", "Earth’s Choice Organic Cranberry Sauce is " +
                "ready-to-serve and enjoy with classic recipes at family meals and holiday celebrations. " +
                "Perfectly tart and delicious because we select the highest standard of organic cranberries" +
                " from farmers who support organic practices, providing sustainable agriculture for future generations.", 0f, 3.99d, 0.398f, R.drawable.canned_cranberry_sauce));
        this.productList.add(new Product("Organic Pumpkin Puree", "Each harvest, the best quality organic" +
                " pumpkins are selected from a cooperative of farms who are dedicated to sustainable agricultural practices." +
                " Earth’s Choice Organic Pumpkin is rich, smooth and ready-to-use. Use in everything from baked delights like" +
                " classic holiday pies to gourmet creations or delicious side dishes.", 4f, 4.69d, 0.398f, R.drawable.canned_pumpkin));
        this.productList.add(new Product("Black Beans", "Black Beans are a versatile bean. Fantastic in soups and stews, they also make a great additions to dips and salsas.", 4f, 1.79d, 0.398f, R.drawable.canned_black_beans));
        this.productList.add(new Product("Chick Peas", "Chick Peas, often known as Garbanzo Beans, are a fantastic all purpose bean. " +
                "Try your hand at making your own hummous or channa masala. Toss them with vegetables and dressing for a fantastic salad!", 5f, 1.89d, 0.398f, R.drawable.canned_chick_peas));
        this.productList.add(new Product("Organic Canned Kidney Beans", "For those who care about what they eat. A kitchen" +
                " classic, great in chilis and soups. Ontario grown by farmers we know. Certified Organic.", 4.22f, 4.69d, 0.540f, R.drawable.canned_red_beans));
        this.productList.add(new Product("Organic Tomatoes, Crushed w/ Basil","Sea salt and organic sweet basil " +
                "add a flavor boost to these crushed tomatoes. The perfect size for a family dinner!", 5f, 5.49d, 0.796f, R.drawable.canned_chery_tomatoes));
        this.productList.add(new Product("Organic Whole Tomatoes",  "These little sweeties are ready for any recipe that asks for peeled tomatoes. Plus, they’re GMO free.", 3f, 4.49d, 0.796f, R.drawable.canned_whole_tomatoes));
        this.productList.add(new Product("Organic Buckwheat Pancake & Waffle Mix", "Organic whole grain wheat flour, organic whole grain" +
                " buckwheat flour, non-aluminum baking powder (mono-calcium phosphate, sodium bicarbonate), sea salt.", 3.6f, 7.99d, 1f, R.drawable.other_pancake_mix));
        this.productList.add(new Product("Organic Apple Cinnamon Overnight Oats", "A refreshing take on the classic " +
                "apple cinnamon oatmeal. Packed with apple chunks and raisins, these oats will leave you pleasantly surprised with every bite.", 2f, 9d, 0.330f, R.drawable.other_oats));
        this.productList.add(new Product("","", 5f, 6.99d, 0.325f, R.drawable.other_granola));

        this.productList.add(new Product("Mrs Crimble's - Chocolate Macaroons", "Coconut macaroons with chocolate flavoured coating", 5f, 5.99d, 0.220f, R.drawable.bakery_macarons));
        this.productList.add(new Product("Buckwheat Chocolate Cookies", "Made with fine dark chocolate; these" +
                " buckwheat chocolate cookies are delicious and fill you full of healthy energy! ", 4.5f, 8.99d, 0.240f, R.drawable.bakery_cookies));
        this.productList.add(new Product("Coco Moko Shortbread", "Melt in your mouth shortbread…Mmmmmmm." +
                " These are Glutenull's original cookies and they’re back! Made with wholesome brown rice flour and high fiber coconut flour.", 5f, 9.99d, 0.320f, R.drawable.bakery_shortbread));
        this.productList.add(new Product("Brown Rice Tortilla", "Food for Life's unique wheat and gluten-free" +
                " tortillas are specifically developed to be moist, delicious and easy to use. 6 x 56g", 5f, 5.39d, 0.336f, R.drawable.bakery_tortilla));
        this.productList.add(new Product("Raisin Bread, Whole Wheat", "This favourite is made with 100% whole wheat and loaded with raisins for a sweet, hearty mouthful.", 2.5f, 5.39d, 0.740f, R.drawable.bakery_bread_whole_wheat));
        this.productList.add(new Product("Organic Emmer Bread", "Emmer, also known as farro, is ancient wheat varietal.", 5f, 5.99d, 0.5f, R.drawable.bakery_bread_sliced));
        this.productList.add(new Product("Ciabatta Buns", "A white bread bun which literally translates" +
                " to \"slipper\" from Italian, the ciabatta is perfect for making toasted sandwiches like panini." +
                " Try slathering them with butter or oil and toasting them on the barbecue for the ultimate burger bun. 4 x 100g", 5f, 4.79d, 0.400f, R.drawable.bakery_chibatta));
        this.productList.add(new Product("Hot Dog Buns", "Unbleached white flour, water, granulated sugar, " +
                "non-hydrogenated canola shortening, fresh yeast, malted barley flour, wheat flour, " +
                "ascorbic acid, barley malt syrup, sea salt, organic wheat flour, enzymes.", 3.77f, 2.99d, 0.300f, R.drawable.bakery_hotdog));
        this.productList.add(new Product("Lemon Ricotta Muffins", "These muffins will melt in your mouth! 5pk", 5f, 11.99d, 0.450f, R.drawable.bakery_muffin_1));
        this.productList.add(new Product("Lemon Blueberry Muffin", "Light and lemony with the taste and goodness of blueberries. 5pk", 4f, 11.99d, 0.450f, R.drawable.bakery_muffin_2));

        this.productList.add(new Product("100% Grass-Fed Ground Beef - LIMITED AVAILABILITY (Frozen)", "Naturally lean due to the grass-finishing, " +
                "this ground beef is a healthier version of everyone's favorite freezer" +
                " staple. Great in tacos, pasta and just about everywhere else!", 4.85f, 8.99d, 0.454f, R.drawable.meat_beef));
        this.productList.add(new Product("Chicken Breast, Lean, Ground (Frozen)", "Serving as a healthier alternative to ground beef," +
                " this local, ground chicken can be used in your taco mix, spaghetti, chilli, and even on your pizza.", 5f, 12.49d, 0.400f, R.drawable.meat_chicken));
        this.productList.add(new Product("MSC Lemon Pepper Sole Tenders (Frozen)", "MSC Sole pieces made with whole muscle and crunchy lemon pepper coating.", 0f, 18.49d, 0.7f, R.drawable.fish_tenders));
        this.productList.add(new Product("Ocean Wise & Wild Sockeye Salmon Candy (Frozen)", "This Hook and Line cau" +
                "ght wild Sockeye Candy is marinated and smoked to perfection.", 3.5f, 9.99d, 0.100f, R.drawable.fish_diced_salmon));
        this.productList.add(new Product("Golden Onion Rings w/ Sea Salt (Frozen)", "Combining sweet" +
                " Spanish onions with a delicate all-natural Japanese style breading" +
                " Alexia Onion Rings have a light and crispy texture and are bursting with real onion flavour.", 4f, 5.39d, 0.340f, R.drawable.frozen_onion_rings));
        this.productList.add(new Product("Organic Ketchup", "Suzie's Organic Ketchup is the classic," +
                " essential ketchup for every family's table. This ORGANIC ketchup is completely" +
                " local to the Northwest and is a MUST have!", 5f, 6.99d, 0.499f, R.drawable.other_ketchup));
        this.productList.add(new Product("Organic 2% Milk Big", "Valley Pride is Avalon Dairy's brand name for all carton and jug milk products.", 5f, 8.89d, 1f, R.drawable.dairy_milk_big));
        this.productList.add(new Product("Organic 2% Milk Small", "Certified organic milk is produced" +
                " using minimal pesticides and fertilizers and relies on crop rotation and " +
                "recycling plant and animal wastes. Valley Pride is produced by Avalon Dairy, BC's oldest local dairy producer.", 5f, 5.99d, 0.5f, R.drawable.dairy_milk_small));
        this.productList.add(new Product("Organic Chocolate Milk", "Avalon milk, BC's oldest local dairy, " +
                "delivers their milk in re-useable glass bottles that may be cleaned and then returned for a refundable $1.25 deposit.", 4f, 4.99d, 1f, R.drawable.dairy_choco_milk));
        this.productList.add(new Product("Grass-fed Triple Cream Brie - Canadian Grand Prix Cheese Awards Finalist", "The “Queen of Cheeses”. " +
                "This is a delicious choice for an appetizer or dessert. Serve it at room temperature" +
                " or warmed slightly. Brie is creamy and rich, yet still mild. Its distinct flavor complements" +
                " almost any fruit, or top with sweet or savory preserves & nuts.", 5f, 10.99d, 0.200f, R.drawable.dairy_cheese));
    }

    public List<Product> getData() {
        return this.productList;
    }
}
