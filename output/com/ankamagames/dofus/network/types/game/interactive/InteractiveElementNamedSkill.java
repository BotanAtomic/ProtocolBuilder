package package com.ankamagames.dofus.network.types.game.interactive;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class InteractiveElementNamedSkill extends InteractiveElementSkill implements INetworkType {

    private int protocolId = 220;
    private int nameId = 0;


    public int getTypeId() {
         return 220;
    }

    public InteractiveElementNamedSkill initInteractiveElementNamedSkill(int param1,int  param2,int  param3) {
         super.initInteractiveElementSkill(param1,param2);
         this.nameId = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.nameId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_InteractiveElementNamedSkill(param1);
    }

    public void serializeAs_InteractiveElementNamedSkill(ICustomDataOutput param1) {
         super.serializeAs_InteractiveElementSkill(param1);
         if(this.nameId < 0)
            throw new Exception("Forbidden value (" + this.nameId + ") on element nameId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InteractiveElementNamedSkill(param1);
    }

    public void deserializeAs_InteractiveElementNamedSkill(ICustomDataInput param1) {
         super.deserialize(param1);
         this._nameIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InteractiveElementNamedSkill(param1);
    }

    public void deserializeAsyncAs_InteractiveElementNamedSkill(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._nameIdFunc);
    }

    private void _nameIdFunc(ICustomDataInput param1) {
         this.nameId = param1.readVarUhInt();
         if(this.nameId < 0)
            throw new Exception("Forbidden value (" + this.nameId + ") on element of InteractiveElementNamedSkill.nameId.");
    }

}