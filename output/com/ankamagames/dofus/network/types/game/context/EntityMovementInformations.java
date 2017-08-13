package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class EntityMovementInformations extends Object implements INetworkType {

    private int protocolId = 63;
    private int id = 0;
    private Vector<int> steps;
    private FuncTree _stepstree;


    public int getTypeId() {
         return 63;
    }

    public EntityMovementInformations initEntityMovementInformations(int param1,Vector<int>  param2) {
         this.id = param1;
         this.steps = param2;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.steps = new Vector.<int>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_EntityMovementInformations(param1);
    }

    public void serializeAs_EntityMovementInformations(ICustomDataOutput param1) {
         param1.writeInt(this.id);
         param1.writeShort(this.steps.length);
         int _loc2_ = 0;
         while(_loc2_ < this.steps.length)
         {
            param1.writeByte(this.steps[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_EntityMovementInformations(param1);
    }

    public void deserializeAs_EntityMovementInformations(ICustomDataInput param1) {
         * _loc4_ = 0;
         this._idFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readByte();
            this.steps.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_EntityMovementInformations(param1);
    }

    public void deserializeAsyncAs_EntityMovementInformations(FuncTree param1) {
         param1.addChild(this._idFunc);
         this._stepstree = param1.addChild(this._stepstreeFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readInt();
    }

    private void _stepstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._stepstree.addChild(this._stepsFunc);
            _loc3_++;
         }
    }

    private void _stepsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.steps.push(_loc2_);
    }

}