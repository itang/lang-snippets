"banana" |> String.to_char_list |> Enum.filter(&(&1 == ?a)) |> length
