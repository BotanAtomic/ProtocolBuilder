package package com.ankamagames.dofus.network.types.game.idol;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PartyIdol extends Idol implements INetworkType {

    private int protocolId = 490;
    private Vector.<Number> ownersIds = ;
    private FuncTree _ownersIdstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 490;
    }

    public PartyIdol initPartyIdol(int param1,int  param2,int  param3,Vector.<Number>  param4) {
         super.initIdol(param1,param2,param3);
         this.ownersIds = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.ownersIds = new Vector.<Number>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PartyIdol(param1);
    }

    public void serializeAs_PartyIdol(ICustomDataOutput param1) {
         super.serializeAs_Idol(param1);
         param1.writeShort(this.ownersIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ownersIds.length)
            if(this.ownersIds[_loc2_] < 0 || this.ownersIds[_loc2_] > 9.007199254740992E15)
               throw new Exception("Forbidden value (" + this.ownersIds[_loc2_] + ") on element 1 (starting at 1) of ownersIds.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyIdol(param1);
    }

    public void deserializeAs_PartyIdol(ICustomDataInput param1) {
         * _loc4_ = NaN;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readVarUhLong();
            if(_loc4_ < 0 || _loc4_ > 9.007199254740992E15)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of ownersIds.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyIdol(param1);
    }

    public void deserializeAsyncAs_PartyIdol(FuncTree param1) {
         super.deserializeAsync(param1);
         this._ownersIdstree = param1.addChild(this._ownersIdstreeFunc);
    }

    private void _ownersIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._ownersIdstree.addChild(this._ownersIdsFunc);
            _loc3_++;
    }

    private void _ownersIdsFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readVarUhLong();
         if(_loc2_ < 0 || _loc2_ > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of ownersIds.");
    }

}