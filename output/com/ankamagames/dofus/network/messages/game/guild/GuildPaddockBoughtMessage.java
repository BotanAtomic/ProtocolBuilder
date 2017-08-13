package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.paddock.PaddockContentInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildPaddockBoughtMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5952;
    private boolean _isInitialized = false;
    private PaddockContentInformations paddockInfo;
    private FuncTree _paddockInfotree;


    public void serialize(ICustomDataOutput param1) {
         this.paddockInfo.serializeAs_PaddockContentInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.paddockInfo = new PaddockContentInformations();
         this.paddockInfo.deserialize(param1);
    }

}