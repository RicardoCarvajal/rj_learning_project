import { GifList } from "./gifs/GifList"
import { PreviousSearches } from "./gifs/PreviousSearches"
import { CustomHeader } from "./share/components/CustomHeader"
import { SearchBar } from "./share/components/SearchBar"
import { useGifs } from "./gifs/hooks/useGifs"

export const GifsApp = () => {

    const {previousTerms, gifs, handleSearch, handleTermClicked} = useGifs()

    return (
        <>
            <CustomHeader title="Buscador de Gifs" description="Los mejores gifs del mundo mundial" />
            <SearchBar placeholder_search="Busca los mejores gifs" onQuery={handleSearch} />
            <PreviousSearches searches={previousTerms} onLabelClicked={handleTermClicked} />
            <GifList gifs={gifs} />
        </>
    )
}

