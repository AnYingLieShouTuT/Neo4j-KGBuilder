<template>
  <div>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="date" label="id" width="180"> </el-table-column>
      <el-table-column prop="name" label="规则" width="180"> </el-table-column>
      <el-table-column prop="address" label="等级"> </el-table-column>
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

export default {
  name: "rules",
  data() {
    return {
      tableData: [], //表格显示的数据
      page: 1,
      size: "",
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
    this.getRules();
  },
  methods: {
    getRules: function () {
      let data = { pageCode: this.params.page, pageSize: this.params.size };
      kgBuilderApi.getRulesPage(data).then((result) => {
        console.log(result);
        if (result.code == 200) {
          console.log(result);
          that = this;
          console.log("分页页面");
          console.log(result.data);
          console.log("分页后");
          that.tableData = result.data.records;
          that.total = result.data.total;
          console.log(this.total);
        }
      });
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
