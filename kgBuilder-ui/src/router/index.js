import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "Home",
        component: () => import("../views/kgbuilder/index_v1.vue")
    },
    {
        path: "/rules",
        name: "rules",
        component: () => import("../views/kgbuilder/components/rules.vue")
    },
    {
        path: "/builder",
        name: "builder",
        component: () => import("../views/kgbuilder/index.vue")
    },
    {
        path: "/kg",
        name: "kg",
        component: () => import("../views/kgbuilder/index_v1.vue")
    },
    // {
    //     path: "/rules",
    //     name: "rules",
    //     component: () => import("../views/kgbuilder/rule_list.vue")
    // },
    //   {
    //     path: "/er",
    //     name: "er",
    //     component: () => import("../views/erbuilder/index.vue")
    //   },
    {
        path: "/about",
        name: "About",
        component: () =>
            import("../views/About.vue")
    }
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes
});

export default router;
