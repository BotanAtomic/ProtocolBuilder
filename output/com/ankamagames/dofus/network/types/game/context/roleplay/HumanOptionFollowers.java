package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.IndexedEntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HumanOptionFollowers extends HumanOption implements INetworkType {

    private int protocolId = 410;
    private Vector<IndexedEntityLook> followingCharactersLook;
    private FuncTree _followingCharactersLooktree;


    public int getTypeId() {
         return 410;
    }

    public HumanOptionFollowers initHumanOptionFollowers(Vector<IndexedEntityLook> param1) {
         this.followingCharactersLook = param1;
         return this;
    }

    public void reset() {
         this.followingCharactersLook = new Vector.<IndexedEntityLook>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HumanOptionFollowers(param1);
    }

    public void serializeAs_HumanOptionFollowers(ICustomDataOutput param1) {
         super.serializeAs_HumanOption(param1);
         param1.writeShort(this.followingCharactersLook.length);
         int _loc2_ = 0;
         while(_loc2_ < this.followingCharactersLook.length)
         {
            (this.followingCharactersLook[_loc2_] as IndexedEntityLook).serializeAs_IndexedEntityLook(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HumanOptionFollowers(param1);
    }

    public void deserializeAs_HumanOptionFollowers(ICustomDataInput param1) {
         IndexedEntityLook _loc4_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new IndexedEntityLook();
            _loc4_.deserialize(param1);
            this.followingCharactersLook.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HumanOptionFollowers(param1);
    }

    public void deserializeAsyncAs_HumanOptionFollowers(FuncTree param1) {
         super.deserializeAsync(param1);
         this._followingCharactersLooktree = param1.addChild(this._followingCharactersLooktreeFunc);
    }

    private void _followingCharactersLooktreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._followingCharactersLooktree.addChild(this._followingCharactersLookFunc);
            _loc3_++;
         }
    }

    private void _followingCharactersLookFunc(ICustomDataInput param1) {
         IndexedEntityLook _loc2_ = new IndexedEntityLook();
         _loc2_.deserialize(param1);
         this.followingCharactersLook.push(_loc2_);
    }

}