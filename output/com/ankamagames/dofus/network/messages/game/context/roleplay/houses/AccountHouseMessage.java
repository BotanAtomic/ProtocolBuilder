package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.house.AccountHouseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AccountHouseMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6315;
    private boolean _isInitialized = false;
    private Vector<AccountHouseInformations> houses;
    private FuncTree _housestree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6315;
    }

    public AccountHouseMessage initAccountHouseMessage(Vector<AccountHouseInformations> param1) {
         this.houses = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.houses = new Vector.<AccountHouseInformations>();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AccountHouseMessage(param1);
    }

    public void serializeAs_AccountHouseMessage(ICustomDataOutput param1) {
         param1.writeShort(this.houses.length);
         int _loc2_ = 0;
         while(_loc2_ < this.houses.length)
         {
            (this.houses[_loc2_] as AccountHouseInformations).serializeAs_AccountHouseInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AccountHouseMessage(param1);
    }

    public void deserializeAs_AccountHouseMessage(ICustomDataInput param1) {
         AccountHouseInformations _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new AccountHouseInformations();
            _loc4_.deserialize(param1);
            this.houses.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AccountHouseMessage(param1);
    }

    public void deserializeAsyncAs_AccountHouseMessage(FuncTree param1) {
         this._housestree = param1.addChild(this._housestreeFunc);
    }

    private void _housestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._housestree.addChild(this._housesFunc);
            _loc3_++;
         }
    }

    private void _housesFunc(ICustomDataInput param1) {
         AccountHouseInformations _loc2_ = new AccountHouseInformations();
         _loc2_.deserialize(param1);
         this.houses.push(_loc2_);
    }

}