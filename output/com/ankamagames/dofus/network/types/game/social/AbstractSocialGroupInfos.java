package package com.ankamagames.dofus.network.types.game.social;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AbstractSocialGroupInfos extends Object implements INetworkType {

    private int protocolId = 416;


    public int getTypeId() {
         return 416;
    }

    public AbstractSocialGroupInfos initAbstractSocialGroupInfos() {
         return this;
    }

    public void reset() {
    }

    public void serialize(ICustomDataOutput param1) {
    }

    public void serializeAs_AbstractSocialGroupInfos(ICustomDataOutput param1) {
    }

    public void deserialize(ICustomDataInput param1) {
    }

    public void deserializeAs_AbstractSocialGroupInfos(ICustomDataInput param1) {
    }

    public void deserializeAsync(FuncTree param1) {
    }

    public void deserializeAsyncAs_AbstractSocialGroupInfos(FuncTree param1) {
    }

}