import BaseAPI from "@/utils/BaseAPI";

class kgBuilderApi extends BaseAPI {
    // 获取图谱数据
    getKgData() {
        return this.get("/static/kgData.json");
    }

    getDomains(data) {
        return this.post("/getGraph", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    createDomain(data) {
        return this.get("/createDomain", data);
    }

    getCypherResult(data) {
        return this.get("/getCypherResult", data);
    }

    getNodeContent(data) {
        return this.post("/getNodeContent", data);
    }

    getNodeImage(data) {
        return this.post("/getNodeImage", data);
    }

    getNodeDetail(data) {
        return this.post("/getNodeDetail", data);
    }

    saveNodeImage(data) {
        return this.post("/saveNodeImage", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    saveNodeContent(data) {
        return this.post("/saveNodeContent", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    getDomainGraph(data) {
        return this.post("/getDomainGraph", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    getRelationNodeCount(data) {
        return this.post("/getRelationNodeCount", data);
    }

    getMoreRelationNode(data) {
        return this.get("/getMoreRelationNode", data);
    }

    deleteDomain(data) {
        return this.post("/deleteDomain", data);
    }

    getRecommendGraph(data) {
        return this.post("/getRecommendGraph", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    createNode(data) {
        return this.post("/createNode", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    createNodeOfRule(data) {
        return this.post("/createRuleNode", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    deleteNode(data) {
        return this.post("/deleteNode", data);
    }

    deleteLink(data) {
        return this.post("/deleteLink", data);
    }

    createLink(data) {
        return this.post("/createLink", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    updateLink(data) {
        return this.post("/updateLink", data);
    }

    updateNodeName(data) {
        return this.post("/updateNodeName", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    updateRuleStatus(data) {
        return this.post("/updateRuleStatus", data);
    }

    batchCreateNode(data) {
        return this.post("/batchCreateNode", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    batchCreateChildNode(data) {
        return this.post("/batchCreateChildNode", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    batchCreateRuleChildNode(data) {
        return this.post("/batchCreateRuleChildNode", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    batchCreateSameNode(data) {
        return this.post("/batchCreateSameNode", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    exportGraph(data) {
        return this.post("/exportGraph", data);
    }

    download(data) {
        return this.get("/download/" + data);
    }

    updateCoordinateOfNode(data) {
        return this.post("/updateCoordinateOfNode", data, {
            headers: {
                "Content-Type": "application/json",
            },
        });
    }

    // getRulesALL() {
    //     return this.post("/rulesAll");
    // }

    getWarningIndexPage(data) {
        return this.post("/warningIndexPage", data);
    }

    getAtomicIndexPage(data) {
        return this.post("/atomicIndexPage", data);
    }

    getEventPage(data) {
        return this.post("/eventPage", data);
    }

    getEventArgumentPage(data) {
        return this.post("/eventArgumentPage", data);
    }

    addEventNode(data) {
        return this.post("/addEventNode", data);
    }
}

export default new kgBuilderApi();
