<template>
  <div>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="id" label="id" width="180"> </el-table-column>
      <el-table-column prop="rule" label="规则" width="180"> </el-table-column>
      <el-table-column prop="level" label="等级" width="180"> </el-table-column>
    </el-table>
    <!--   element-ui分页组件-->
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="this.params.page"
        :page-sizes="[1, 2, 3, 4]"
        :page-size="this.params.size"
        layout="total, sizes, prev, pager, next, jumper"
        :total="this.total"
      >
      </el-pagination>
    </div>
  </div>
</template>
<script>
import { kgBuilderApi } from "@/api";
import axios from "axios";

export default {
  name: "rules",
  data() {
    return {
      tableData: [], //表格显示的数据
      page: 1,
      size: 0,
      total: 0,
      params: {
        page: 1,
        size: 3,
      },
    };
  },
  components: {},
  mounted() {},
  created() {
    // this.getAll();
    console.log("created");
    this.getRules();
  },
  methods: {
    getRules: function () {
      let that = this;
      let data = { pageCode: this.params.page, pageSize: this.params.size };
      kgBuilderApi.getRulesPage(data).then((result) => {
        console.log(result);
        if (result.code == 200) {
          console.log(result);
          console.log("分页页面");
          console.log(result.data);
          console.log("分页后");
          that.tableData = result.data.records;
          that.total = result.data.total;
          console.log(this.total);
        }
      });
      //   axios
      //     .post(
      //       "http://localhost:8080/rulesPage",
      //       { params: data },
      //       {
      //         headers: {
      //           "Access-Control-Allow-Origin": "*", //解决cors头问题
      //           "Access-Control-Allow-Credentials": "true", //解决session问题
      //           "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8", //将表单数据传递转化为form-data类型
      //         },
      //         withCredentials: true,
      //       }
      //     )
      //     .then(() => {
      //       if (result.code == 200) {
      //         console.log(result);
      //         that = this;
      //         console.log("分页页面");
      //         console.log(result.data);
      //         console.log("分页后");
      //         that.tableData = result.data.records;
      //         that.total = result.data.total;
      //         console.log(this.total);
      //       }
      //     });
    },
    getAll() {
      //发送异步请求
      axios.get("http://localhost:8080/rulesPage").then((res) => {
        console.log(result);
        this.tableData = res.data;
      });
    },
    //    分页
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.params.size = val;
      this.getRules();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.params.page = val;
      this.getRules();
    },
    // pagehelper: function () {
    //   that = this;
    //   axios
    //     .get(
    //       "http://localhost:/userinfo/page/" + this.params.page + "/" + this.params.size
    //     )
    //     .then((res) => {
    //       console.log("分页页面");
    //       console.log(res.data);
    //       console.log("分页后");
    //       that.tableData = res.data.records;
    //       that.total = res.data.total;
    //       console.log(this.total);
    //     });
    // },
  },
};
</script>
<style></style>
