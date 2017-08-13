package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.IndexedEntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HumanOptionFollowers extends HumanOption implements INetworkType {

    private int protocolId = 410;
    private IndexedEntityLook[] followingCharactersLook;
    private FuncTree _followingCharactersLooktree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.followingCharactersLook.length);
         int _loc2_ = 0;
         while(_loc2_ < this.followingCharactersLook.length)
         {
            (this.followingCharactersLook[_loc2_] as IndexedEntityLook).serializeAs_IndexedEntityLook(param1);
            _loc2_++;
         }
         param1.writeShort(this.followingCharactersLook.length);
         int _loc2_ = 0;
         while(_loc2_ < this.followingCharactersLook.length)
         {
            (this.followingCharactersLook[_loc2_] as IndexedEntityLook).serializeAs_IndexedEntityLook(param1);
            _loc2_++;
         }
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
         IndexedEntityLook _loc4_ = null;
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

}