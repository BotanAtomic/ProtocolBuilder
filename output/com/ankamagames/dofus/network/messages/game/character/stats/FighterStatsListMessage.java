package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.characteristic.CharacterCharacteristicsInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FighterStatsListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6322;
    private boolean _isInitialized = false;
    private CharacterCharacteristicsInformations stats;
    private FuncTree _statstree;


    public void serialize(ICustomDataOutput param1) {
         this.stats.serializeAs_CharacterCharacteristicsInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.stats = new CharacterCharacteristicsInformations();
         this.stats.deserialize(param1);
    }

}