import Carousel from "./components/Carousel";
import ExploreTopBooks from "./components/ExploreTopBooks";
import { Heros } from "./components/Heros";
import LibraryServices from "./components/LibraryServices";

const HomePage = () => (
    <>
        <ExploreTopBooks />
        <Carousel />
        <Heros />
        <LibraryServices />
    </>
)

export default HomePage;
