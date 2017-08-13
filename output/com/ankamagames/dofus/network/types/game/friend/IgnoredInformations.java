package com.ankamagames.dofus.network.types.game.friend;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IgnoredInformations extends AbstractContactInformations implements INetworkType {

    private int protocolId = 106;


    public int getTypeId() {
         return 106;
    }

    public IgnoredInformations initIgnoredInformations(int param1,String  param2) {
         super.initAbstractContactInformations(param1,param2);
         return this;
    }

    public void reset() {
         super.reset();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_IgnoredInformations(param1);
    }

    public void serializeAs_IgnoredInformations(ICustomDataOutput param1) {
         super.serializeAs_AbstractContactInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IgnoredInformations(param1);
    }

    public void deserializeAs_IgnoredInformations(ICustomDataInput param1) {
         super.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IgnoredInformations(param1);
    }

    public void deserializeAsyncAs_IgnoredInformations(FuncTree param1) {
         super.deserializeAsync(param1);
    }

}