package com.ankamagames.dofus.network.types.game.friend;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IgnoredInformations extends AbstractContactInformations implements INetworkType {

    private int protocolId = 106;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractContactInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of AbstractContactInformations.accountId.");
         }
         this.accountName = param1.readUTF();
    }

}