package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class HumanOptionEmote extends HumanOption implements INetworkType {

    private int protocolId = 407;
    private int emoteId = 0;
    private Number emoteStartTime = 0;


    public int getTypeId() {
         return 407;
    }

    public HumanOptionEmote initHumanOptionEmote(int param1,Number  param2) {
         this.emoteId = param1;
         this.emoteStartTime = param2;
         return this;
    }

    public void reset() {
         this.emoteId = 0;
         this.emoteStartTime = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HumanOptionEmote(param1);
    }

    public void serializeAs_HumanOptionEmote(ICustomDataOutput param1) {
         super.serializeAs_HumanOption(param1);
         if(this.emoteId < 0 || this.emoteId > 255)
            throw new Exception("Forbidden value (" + this.emoteId + ") on element emoteId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HumanOptionEmote(param1);
    }

    public void deserializeAs_HumanOptionEmote(ICustomDataInput param1) {
         super.deserialize(param1);
         this._emoteIdFunc(param1);
         this._emoteStartTimeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HumanOptionEmote(param1);
    }

    public void deserializeAsyncAs_HumanOptionEmote(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._emoteIdFunc);
         param1.addChild(this._emoteStartTimeFunc);
    }

    private void _emoteIdFunc(ICustomDataInput param1) {
         this.emoteId = param1.readUnsignedByte();
         if(this.emoteId < 0 || this.emoteId > 255)
            throw new Exception("Forbidden value (" + this.emoteId + ") on element of HumanOptionEmote.emoteId.");
    }

    private void _emoteStartTimeFunc(ICustomDataInput param1) {
         this.emoteStartTime = param1.readDouble();
         if(this.emoteStartTime < -9.007199254740992E15 || this.emoteStartTime > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.emoteStartTime + ") on element of HumanOptionEmote.emoteStartTime.");
    }

}