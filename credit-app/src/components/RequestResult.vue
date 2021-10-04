<template>
  <div class="result" :class="{ danger: background}">
    <div class="message">
      <slot />
    </div>
    <button class="button" @click="onClick">Forma Dön</button>
  </div>
</template>

<script>
export default {
  props: ["background"],
  methods: {
    onClick() {
      this.$emit("reset");
    },
  },
};
</script>

<style scoped>
.result{
    display: inline-block;
    position: relative;
    background: #ACE1AF;
    height: 10rem;
    text-align: center;
    border-radius: 1rem;
}

.danger {
    background: #e57373;
}

.message {
    font-size: 1.5rem;
    padding: 1rem;
}

.button {
    border: none;
    position: absolute;
    bottom: 15px;
    left: 40%;
    border-radius: 0.45rem;
    background: #0074D9;
    size: 2rem;
    padding: 15px 32px;
    color: white;

}
</style>
