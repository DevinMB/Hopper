<template>
  <div id="outer-div">
    <form id="add-review-form" v-on:submit.prevent>
      <div class="field">
        <label class="form-label" for="rating">Rating: </label>
        <select class="field" name="score" v-model="review.score">
          <option value="">--Please choose an option--</option>
          <option v-for="num in 5"
          v-bind:key="num" :value="num">{{num}}</option>
        </select>
      </div>
      <div class="field">
        <label class="form-label" for="message">Review: </label>
        <input
          type="textarea"
          name="message"
          id="message"
          v-model="review.message"
        />
      </div>

      <div class="actions">
        <button type="submit" v-on:click="addReview()">Add Review</button>
      </div>
    </form>
  </div>
</template>

<script>
import ReviewService from "../services/ReviewService.js";

export default {
  name: "create-review",
  data() {
    return {
      review: {
        message: "",
        score: "",
        beerId: "",
        userId: "",
      },
    };
  },

  methods: {
    addReview() {
      ReviewService.createReview(this.review).then((response) => {
        if (response.status === 201) {
          this.$router.push({ name: "beerDetail" });
        }
      })
            .catch((error) => {
          this.handleErrorResponse(error, "creating");
        });
    },
        handleErrorResponse(error, verb) {
      if (error.response) {
        this.errorMsg =
          "Error " +
          verb +
          " review. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) {
        this.errorMsg =
          "Error " + verb + " review. Server could not be reached.";
      } else {
        this.errorMsg =
          "Error " + verb + " review. Request could not be created.";
      }
    },
    scoreToInt() {

    }
  },
  created() {
    this.review.beerId = this.$store.state.activeBeer.beerId;
    this.review.userId = this.$store.state.user.id;
  },
};
</script>

<style scoped>
#message {
  width: 15em;
  height: 15em;
}
#outer-div {
  min-height: 72vh;
}
</style>