package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.house.HouseInformationsForGuild;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildHouseUpdateInformationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6181;
    private boolean _isInitialized = false;
    private HouseInformationsForGuild housesInformations;
    private FuncTree _housesInformationstree;


    public void serialize(ICustomDataOutput param1) {
         this.housesInformations.serializeAs_HouseInformationsForGuild(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.housesInformations = new HouseInformationsForGuild();
         this.housesInformations.deserialize(param1);
    }

}